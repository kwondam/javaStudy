//clone�� ����Ҷ�, �⺻Ÿ�԰� String�� ���������� Ŭ�δ��� �Ǵµ� ��̴� �ȵ�. �Ϸ��� �Ʒ��� ���� �������


package cloning;

import java.util.ArrayList;
import java.util.Arrays;

class Student implements Cloneable{
	ArrayList<String> StudentnumList;
	
	public Student(ArrayList<String> StudentnumList) {
		this.StudentnumList=StudentnumList;
	}
/*
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student std = (Student) obj;
			return( this.Studentnum == std.Studentnum);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Studentnum;
	}
*/

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Student s = (Student)super.clone();
		s.StudentnumList = (ArrayList) StudentnumList.clone(); // ArrayList���� clone()�� ������ �Ǿ�����
		return s;
	}
	
	
}


public class Cloning {
	public static void main(String[] args) throws CloneNotSupportedException {
		ArrayList<String> kk;
		Student a = new Student(kk=new ArrayList<String>());
		kk.add("100");
		Student c =  (Student) a.clone();
		System.out.println(c.StudentnumList);
		kk.set(0, "300");
		
		
		System.out.println(c.StudentnumList);
		
		
		//System.out.println(a.equals(b));
		//System.out.println(a);
		//System.out.println(b);
		
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		
		//System.out.println(i1.hashCode());
		//System.out.println(i2.hashCode());
		//System.out.println(i1.equals(i2));
	}

	

}
