package StudentSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args){
        ArrayList<Student> list=new ArrayList<>();
        loop:while(true){System.out.println("----------欢迎使用学生管理系统----------");
            System.out.println("MENU");
            System.out.println("1->添加学生");
            System.out.println("2->删除学生");
            System.out.println("3->修改学生");
            System.out.println("4->查询学生");
            System.out.println("5->结束使用");
            System.out.println("请输入您需要使用的功能（1/2/3/4/5）");
            Scanner sc=new Scanner(System.in);
            String choose=sc.next();
            switch (choose){
                case"1"-> addStudent(list);
                case"2"-> deleteStudent(list);
                case"3"-> updateStudent(list);
                case"4"-> queryStudent(list);
                case"5"-> {
                    System.out.println("结束使用");
                    break loop;/*跳跃终止标识 or System.exit(0)//停止虚拟机运行*/
                }
                default-> System.out.println("越界使用");
            }}
    }
    public static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        String Id;
        boolean Idjudge;
        do{Idjudge=false;
            System.out.println("请输入所要添加学生的id以方便系统校验是否已被占用（id格式：0001）");
            Id=sc.next();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(Id)) {
                    System.out.println("您添加的学生id已被占用，请校验后重新输入");Idjudge=true;break;
                }//输入重复id终止本次输入
            }}while(Idjudge);
        System.out.println("该id未被占用，本次录入合法，请您继续输入该学生的姓名、年龄及家庭住址");
        String Name = sc.next();
        int Age = sc.nextInt();
        String Address = sc.next();
        Student stu = new Student(Id, Name, Age, Address);
        list.add(stu);
        System.out.println("成功添加");
    }//添加学生
    public static void deleteStudent(ArrayList<Student> list){
        String Id;
        boolean Idjudge;
        Scanner sc=new Scanner(System.in);
        do{Idjudge=false;
            System.out.println("请输入要删除学生的id");
            Id=sc.next();
            for (int i = 0; i < list.size(); i++) {
                if(Id.equals(list.get(i).getId())){
                    list.remove(i);return;
                }else{
                    Idjudge=true;
                    System.out.println("不存在该学生，请校验后重新输入要删除学生的id");
                }
            }}while(Idjudge);
    }//删除学生
    public static void updateStudent(ArrayList<Student> list){
        String Id;
        boolean Idjudge;
        Scanner sc=new Scanner(System.in);
        do{Idjudge=false;
            System.out.println("请输入要修改学生的id");
            Id=sc.next();
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getId().equals(Id)){
                    System.out.println("1->修改学生姓名---2->修改学生年龄---3->修改学生地址---4->结束修改");
                    System.out.println("请输入你要进行的操作");
                    Scanner sc2=new Scanner(System.in);
                    loop2:while(true){
                        String choose=sc2.next();
                        switch(choose){
                            case"1"->{
                                System.out.println("现在正在进行修改学生姓名操作，当前姓名为"+list.get(i).getName()+"，请输入要修改为的姓名");
                                Scanner sc3=new Scanner(System.in);
                                String newname=sc3.next();
                                list.get(i).setName(newname);
                                System.out.println("修改成功，当前姓名为"+list.get(i).getName());
                            }
                            case"2"->{
                                System.out.println("现在正在进行修改学生年龄操作，当前年龄为"+list.get(i).getAge()+"，请输入要修改为的年龄");
                                Scanner sc3=new Scanner(System.in);
                                int newage=sc3.nextInt();
                                list.get(i).setAge(newage);
                                System.out.println("修改成功，当前年龄为"+list.get(i).getAge());
                            }
                            case"3"-> {
                                System.out.println("现在正在进行修改学生住址操作，当前住址为" + list.get(i).getAddress() + "，请输入要修改为的住址");
                                Scanner sc3 = new Scanner(System.in);
                                String newaddress = sc3.next();
                                list.get(i).setAddress(newaddress);
                                System.out.println("修改成功，当前住址为" + list.get(i).getAddress());
                            }
                            case"4"->{
                                break loop2;
                            }
                        }
                    }
                }else{Idjudge=true;
                    System.out.println("不存在该学生，请校验后重新输入要删除学生的id");}
            }
        }while(Idjudge);
    }//修改学生
    public static void queryStudent(ArrayList<Student> list){
        if(list.size()==0){
            System.out.println("当前未录入学生数据");
            return;//结束方法
        }
        System.out.println("id\t姓名\t\t年龄\t\t家庭住址");//表头
        //list中已经存储了学生数据
        for (int i = 0; i < list.size(); i++) {
            Student stu=list.get(i);
            System.out.println(stu.getId()+"\t"+stu.getName()+"\t"+stu.getAge()+"\t"+stu.getAddress());
        }
    }//查询学生
}
