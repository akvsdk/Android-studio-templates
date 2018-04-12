package com.j1ang.base.rx;

import android.content.Context;

import com.j1ang.base.utils.ACache;

import java.io.Serializable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


/**
 * author  Joy
 * Date:  2017/9/5.
 * version:  V1.0
 * Description:
 */
public class RxCache {

    /**
     * @param context
     * @param cacheKey
     * @param expireTime
     * @param fromNetwork
     * @param forceRefresh
     * @param <T>
     * @return
     */
    public static <T> Observable<T> load(final Context context,
                                         final String cacheKey,
                                         final int expireTime,
                                         Observable<T> fromNetwork,
                                         boolean forceRefresh) {
        Observable<T> fromCache = Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> e) throws Exception {
                //获取缓存
                T cache = (T) ACache.get(context).getAsObject(cacheKey);
                if (cache != null) {
                    e.onNext(cache);
                } else {
                    e.onComplete();
                }
            }

        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

        /**
         * 这里的fromNetwork 不需要指定Schedule,在handleRequest中已经变换了
         */
        fromNetwork = fromNetwork.map(new Function<T, T>() {
            @Override
            public T apply(@NonNull T result) throws Exception {
                //保存缓存
                ACache.get(context).put(cacheKey, (Serializable) result, expireTime);
                return result;
            }

        });
        //强制刷新则返回接口数据
        if (forceRefresh) {
            return fromNetwork;
        } else {
            //优先返回缓存
            return Observable.concat(fromCache, fromNetwork).firstElement().toObservable();
        }
    }


}
