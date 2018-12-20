
public class FormController {
  Item item;
  String date;
  static int FormID=0;
  int UserID;
  void FillForm(Item i, String d, int ID){
	  FormController f = new FormController();
	  FormController w = new FormController();
	  f.FormID++;
	  f.item =i;
	  f.date = d;
	  f.UserID = ID;
	  addForm(f);
	  Connect(f);
	  notification(f);
  }
  void addForm(FormController f){
	  //adding fel database
  }
  void deleteForm(int FormID){
	  //delete mn el database
  }
  FormController getForm(int FormID){
	  //select from database
  }
  FormController Connect(FormController f){
	  //search fel db eno fe item zy f w nafs el date
	  //return 
  } 
  void notification(FormController f){
	   // a
  }
}
