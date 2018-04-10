package ${packageName}.${Model}.ui.fragment;

import android.view.View;

import ${packageName}.R;
import ${packageName}.base.CommonFragment;
import ${packageName}.${Model}.contract.${ContractName};
import ${packageName}.${Model}.presenter.${PresenterName};
import ${packageName}.${Model}.model.${ContractName};

 /**
 * Date:  ${DATE}
 * version:  V1.0
 * Description:
 * @author Joy
 */

public class ${FragmentName} extends CommonFragment<${PresenterName},${ModelName}> implements ${ContractName}.View{

    public static ${FragmentName} newInstance() {
        ${FragmentName} fragment = new ${FragmentName}();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_${Model}_${fragment_layout};
    }

    @Override
    public void initView(View view) {

    }

    
    @Override
    public void initData() {

    }

    @Override
     public void initPresenter() {
        mPresenter.setVM(this, mModel);
     }

    @Override
    public void showErrorTip(String msg) {
        showErrorToast(msg);
    }
        
}
