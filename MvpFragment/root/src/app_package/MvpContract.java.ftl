package ${packageName}.${Model}.contract;

import ${packageName}.base.BaseModel;
import ${packageName}.base.BasePresenter;
import ${packageName}.base.BaseView;


 /**
 * Date:  ${DATE}
 * version:  V1.0
 * Description:
 * @author Joy
 */

public interface ${ContractName} {

    interface Model extends BaseModel {

    }

    interface View extends BaseView {
 
    }


    abstract class Presenter extends BasePresenter<View,Model>{

    }


}