import { Component, OnInit } from '@angular/core';
import { Faculty } from 'src/app/model/faculty';
import { FacultyService } from 'src/app/services/faculty-service/faculty.service';
import { StudyProgram } from 'src/app/model/studyProgram';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-add-study-program',
  templateUrl: './add-study-program.component.html',
  styleUrls: ['./add-study-program.component.scss']
})
export class AddStudyProgramComponent implements OnInit {

  faculty: Faculty[];
  studyProgram: StudyProgram = new StudyProgram();
  form: FormGroup;
  

  constructor(private facultyService: FacultyService,
              private fb:FormBuilder,
              private snackBar: MatSnackBar) { 

                this.form = fb.group({
                  'name': [null],
                  'description' :[null],
                  'faculty': [null],
                  'manager' :[null]
                });
  }

  ngOnInit() {

    
    this.facultyService.getFaculties().subscribe(
      data => this.faculty = data
    )
  }


  onSubmit(selectedFaculty){

    this.studyProgram.name = this.form.get("name").value;
    this.studyProgram.description = this.form.get("description").value;
    this.studyProgram.faculty.id = selectedFaculty;
     
   console.log( this.studyProgram)
   this.facultyService.addNewStudyProgram(this.studyProgram).subscribe();
   this.openSnackBar("You have successfully added new Study Program", "Close");
  }



  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 3000,
    });
  }
}
