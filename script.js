let students=[];

function addStudent(){

let name=document.getElementById("name").value;
let roll=document.getElementById("roll").value;
let marks=document.getElementById("marks").value;

if(name=="" || roll=="" || marks=="")
{
alert("Please fill all fields");
return;
}

let student={
name:name,
roll:roll,
marks:marks
};

students.push(student);

alert("Student Added");

clearFields();

}

function clearFields(){

document.getElementById("name").value="";
document.getElementById("roll").value="";
document.getElementById("marks").value="";

}

function displayStudents(){

let table=document.getElementById("tableBody");

table.innerHTML="";

for(let i=0;i<students.length;i++)
{

let row="<tr>";

row+="<td>"+(i+1)+"</td>";
row+="<td>"+students[i].name+"</td>";
row+="<td>"+students[i].roll+"</td>";
row+="<td>"+students[i].marks+"</td>";

row+="</tr>";

table.innerHTML+=row;

}

}

function searchStudent(){

let roll=document.getElementById("searchRoll").value;

for(let i=0;i<students.length;i++)
{

if(students[i].roll==roll)
{
alert("Student Found: "+students[i].name+" Marks: "+students[i].marks);
return;
}

}

alert("Student Not Found");

}

function sortStudents(){

students.sort(function(a,b){

return b.marks-a.marks;

});

displayStudents();

}

function deleteStudent(){

let roll=prompt("Enter Roll Number To Delete");

for(let i=0;i<students.length;i++)
{

if(students[i].roll==roll)
{
students.splice(i,1);
alert("Student Deleted");
displayStudents();
return;
}

}

alert("Student Not Found");

}

function resetStudents(){

students=[];

document.getElementById("tableBody").innerHTML="";

alert("All Records Deleted");

}

function logout(){

window.location.href="login.html";

}
