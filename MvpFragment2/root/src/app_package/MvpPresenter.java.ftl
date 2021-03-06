package ${packageName}.${Model}.presenter;

import android.content.Context;

import ${packageName}.${Model}.contract.${ContractName};
import ${packageName}.${Model}.model.${ModelName};



 /**
 * Date:  ${DATE}
 * version:  V1.0
 * Description:
 * @author Joy
 */
 
public class ${PresenterName} extends ${ContractName}.Presenter {

	private ${ModelName} mModel;

	@Override
    public void onStart() {
        mModel = new ${ModelName}();
    }


}