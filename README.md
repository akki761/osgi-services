to avail all services a service is prepared

<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <title>Title</title>
</head>
<body>
<div data-sly-use.result="com.sling.com.sling.bundle.UseImpl">
<ul data-sly-list=${result.students}>
<li>${item}</li>
</ul>
</div>
<form action="/content/delete.html">
<input type="hidden" name="operation" value="get"/>
<input type="number" name="id"/>
<input type="submit" name="submit" value="Delete Student">
</form>
<form action="/content/status.html">
<input type="hidden" name="operation" value="get"/>
<input type="number" name="id"/>
<input type="submit" name="submit" value="Student Pass Status">
</form>
<a href="/content/student-form.html">Add Student</a>
</body>
</html>


1) Student is added via form 

<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <title>Title</title>
</head>
<body>
<form action="/content/add-student.html">
Id:<input type="number" name="id"/><br>
Name<input type="text" name="name"/><br>
Marks:<input type="number" name="marks"/><br>
Age;<input type="number" name="age"/><br>
<input type="submit" name="submit"/><br>
</form>
</body>
</html>

2) add-student.html shows list of added student
<!DOCTYPE html>
<html>
<head>
   
   <title>Title</title>
</head>
<body>
    <div data-sly-use.result="com.sling.com.sling.bundle.AddStudent">
    <ul data-sly-list="${result.students}">
       <li> ${item}</li>
    </ul>
</div>
</body>
</html>

3) to delete student corresponding id is provided and deleted student is listed via

<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <title>Title</title>
</head>
<body>
<div data-sly-use.result="com.sling.com.sling.bundle.DeleteStudent">
<ul data-sly-list=${result.students}>
<li>${item}</li>
</ul>
</div>
  
  4) to get status of a student his/her id is required and his/her status is listed out
  
  <!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <title>Title</title>
</head>
<body>
<div data-sly-use.result="com.sling.com.sling.bundle.StudentStatus">
<p>${result.message}</p>
</div>

