package ${packageName}.${Model}.ui.activity;

import android.content.Context;
import android.content.Intent;

import ${packageName}.R;
import ${packageName}.base.CommonActivity;
import ${packageName}.${Model}.contract.${ContractName};
import ${packageName}.${Model}.presenter.${PresenterName};
import ${packageName}.${Model}.model.${ContractName};

 /**
 * Date:  ${DATE}
 * version:  V1.0
 * Description:
 * @author Joy
 */

public class ${ActivityName} extends CommonActivity<${PresenterName},${ModelName}> implements ${ContractName}.View{

		
    public static void start(Context context) {
        Intent intent = new Intent(context, ${ActivityName}.class);
        context.startActivity(intent);
    }


	@Override
    public int setLayoutId() {
        return R.layout.activity_${Model}_${activity_layout};
    }

     @Override
     public void initPresenter() {
        mPresenter.setVM(this, mModel);
     }
	
	@Override
    public void initData() {

    }

    @Override
    public void showErrorTip(String msg) {
        showErrorToast(msg);
    }
		
}
