package shangXueTang;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

class   Test implements TestInterface  {

	@Override
	public void angle() {
		System.out.println("����һ��СС�Ĳ���");
		
	}

	@Override
	public void woman() {
		// TODO �Զ����ɵķ������
		System.out.println("����test�Ĳ��Խӿ�");
	}

	 public static void main(String[] args){
		 
		 Test t = new Test();
		 t.angle();
		 t.woman();
		 System.out.println(x);
	 }
	
	
}
