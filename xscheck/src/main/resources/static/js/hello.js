function addCheck(){
       var majorclass=$("#majorclass").val();
       var coursename=$("#coursename").val();
       $("#checkDatagrid").datagrid(
         url: "/getCheckStudent",
          {
           "majorclass":majorclass,
           "coursename":coursename
          });
    }