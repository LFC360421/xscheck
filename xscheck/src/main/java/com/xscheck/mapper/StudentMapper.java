package com.xscheck.mapper;

import com.xscheck.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
   //显示所有学生信息
   //动态查询  type:指定一个类    method:使用这个类中的方法返回的sql字符串作为查询的语句
   @SelectProvider(type = DynaSql.class,method ="findAllStudent")
   /* @Select("<script>select * from student " +
            "<where>"+
            "<if test=\"sno!=null\">sno=#{sno}</if>"+
            "<if test=\"majorclass!=null\"> AND majorclass=#{majorclass}</if>"  +
            "</where>"+
            "</script>")*/
    List<Student> findAllStudent(Student student);

    //查询total总数
    @SelectProvider(type = DynaSql.class,method = "findStudentTotal")
//    @Select("<script>select count（sno) from student " +
//            "<where>"+
//            "<if test=\"sno!=null\">sno=#{sno}</if>"+
//            "<if test=\"majorclass!=null\"> AND majorclass=#{majorclass}</if>"  +
//            "</where>"+
//            "</script>")
    int findStudentTotal(Student student);

    //添加学生信息
    @Insert("insert into student(sno,sname,sex,phone,password,majorclass) values (#{sno},#{sname},#{sex},#{phone},#{password},#{majorclass})")
    void addStudent(Student student);

    //修改学生信息
    @Update("update student set sname=#{sname},sex=#{sex},phone=#{phone},majorclass=#{majorclass} where sno=#{sno}")
    int updateStudent(Student student);

    //删除学生信息
    @Delete("delete from student where sno=#{sno}")
    void deleteStudent(int sno);

    //查询要导出的学生信息
    @Select("select sno,sname,sex,phone,majorclass from student ")
    List<Student> dataStudent();
}
