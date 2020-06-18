$(function(){
     $("#user_insert_btn").click(function() {
        var lno = $('#name').val();
        var password = $('#password').val();
        var role= $("#test option:selected").val();
//        var myselect=document.getElementById("test");
//        var role=myselect.options[index].value;

            $.ajax({
                type:"POST",
                url:"/login",
                dataType:"json",
                data:{
                    lno:lno,
                    password:password,
                    role:role
                },
                success:function(data){
                    if(data==1){
                        window.location.href = "/admin_main";
//                          window.location.herf="/student_main";
                     }
                    if(data=="2"){
                        window.location.href = "/student_main";
                     }
                     if(data=="3"){
                        window.location.href="/teacher_main";

                     }
                     if(data=="-1"){
                        alert("用户名或密码错误!");
                     }

                 }

            });
      });
});