/**
 * 
 */
package StudentInformation;

import java.util.ArrayList;

/**
 * @author SouthWind
 *	操作类声明
 */
public interface Operation {
	//CRUD 增删改查
	public abstract void create(ArrayList<StudentDate> stu_list);//增
	public abstract void read(ArrayList<StudentDate> stu_list); //查
	public abstract void update(ArrayList<StudentDate> stu_list);//改
	public abstract void delete(ArrayList<StudentDate> stu_list);//删
}
