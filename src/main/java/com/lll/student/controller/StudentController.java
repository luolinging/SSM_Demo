package com.lll.student.controller;

import com.lll.student.common.MyException;
import com.lll.student.common.Result;
import com.lll.student.domain.Student;
import com.lll.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author luo
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    /**
     * 查询所有
     * @return 一组student 对象
     */
    @RequestMapping(value = "findAll",method = RequestMethod.GET)
    public @ResponseBody List<Student> findAll(){
        // 调用service层的方法
        List<Student> studentList = studentService.findAll();
        return studentList;
    }
/*   @RequestMapping(value = "findAll", method = RequestMethod.GET)
   public @ResponseBody Result<List<StudentDTO>> findAll(){
       // 调用service的方法
       List<Student> studentList = studentService.findAll();
       List<StudentDTO> studentDTOList = Lists.newArrayList();
       for (Student student : studentList) {
           StudentDTO studentDTO = assemblerStudent(student);
           studentDTOList.add(studentDTO);
       }
       return Result.wrapSuccessResult(studentDTOList);
   }

   private StudentDTO assemblerStudent(Student student){
       StudentDTO studentDTO = new StudentDTO();
       BeanUtils.copyProperties(student, studentDTO);
       return studentDTO;
   }*/

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public @ResponseBody Result insert(@RequestBody Student student){
        studentService.insert(student);
        return  new Result<>("200", true,null,student);
    }

    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public @ResponseBody Result delete(Long id){
       // bug：删除该条记录虽然成功了，但是http请求报404错误.  原因：没有写@ResponseBody
       studentService.delete(id);
       return new Result<>("200", true,null,null);
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public @ResponseBody Result update(@RequestBody Student student){
       // bug： 得先判断该id的student存不存在
        // 目前不存在的id，也修改成功了？？？？？
        studentService.update(student);
        return new Result<>("200", true,null,null);
    }

    @RequestMapping(value = "findById",method = RequestMethod.GET)
    public @ResponseBody Result<Student> findById(@RequestParam Long id){
        if(id < 0){
            throw new MyException("-1","测试数据");
        }
        Student student = studentService.findById(id);
        return  new Result<>("200", true,null,student);
    }

    @RequestMapping(value = "findByName",method = RequestMethod.GET)
    public @ResponseBody List<Student> findByName(@RequestParam String name){
        // bug：不知道模糊查询怎么写，感觉SQL语句写错了
        List<Student> students = studentService.findByName(name);
        return students;
    }
}
