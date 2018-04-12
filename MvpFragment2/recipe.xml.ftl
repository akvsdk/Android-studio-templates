<?xml version="1.0"?>
<recipe>



	<!-- instantiate 表示创建文件到指定文件夹	（把需要创建文件的模板放在root文件夹下对应文件夹）	  -->
    <instantiate from="root/res/layout/fragment_layout.xml.ftl" 
					to="${escapeXmlAttribute(resOut)}/layout/fragment_${Model}_${fragment_layout}.xml" />
    <instantiate from="root/src/app_package/MvpFragment.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${Model}/ui/fragment/${FragmentName}.java" />
    <instantiate from="root/src/app_package/MvpPresenter.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${Model}/presenter/${PresenterName}.java" />
    <instantiate from="root/src/app_package/MvpContract.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${Model}/contract/${ContractName}.java" />
	<instantiate from="root/src/app_package/MvpModel.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${Model}/model/${ModelName}.java" />

</recipe>
