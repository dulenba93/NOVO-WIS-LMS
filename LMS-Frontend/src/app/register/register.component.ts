import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl, FormGroupDirective, NgForm } from '@angular/forms'
import { AdminService } from '../services/admin-service/admin.service';
import { ErrorStateMatcher } from '@angular/material/core';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material';
import { Student } from '../model/student';
import { Teacher } from '../model/teacher';
import { Administration } from '../model/administration';

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const invalidCtrl = !!(control && control.invalid && control.parent.dirty);
    const invalidParent = !!(control && control.parent && control.parent.invalid && control.parent.dirty);

    return (invalidCtrl || invalidParent);
  }
}

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  student: Student = new Student();
  teacher: Teacher = new Teacher();
  administrator: Administration = new Administration();

  hide = true;

  roles: string[] = ['Student', 'Teacher', 'Administration'];

  role: string = '';

  registerForm: FormGroup;

  matcher = new MyErrorStateMatcher();

  constructor(
    private adminService: AdminService,
    private fb: FormBuilder,
    public dialogRef: MatDialogRef<RegisterComponent>,
    private snackBar: MatSnackBar
  ) {
  }

  ngOnInit() {
    this.registerForm = this.fb.group({
      firstName: [null, Validators.required],
      lastName: [null, Validators.required],
      username: [null, [Validators.required, Validators.minLength(6)]],
      password: [null, [Validators.required, Validators.minLength(8)]],
      confirmPassword: [null, [Validators.required, Validators.minLength(8)]],
      email: [null, [Validators.required, Validators.email]],
      role: [null, Validators.required],
      cardNumber: [null, Validators.required]
    },
      { validator: this.checkPasswords });
  }

  onSubmit() {
    const user = this.registerForm.value;
    delete user['re_password'];
    if (user['role'] === 'Student') {
      delete user['role'];
      this.student = user;
      this.adminService.addNewStudent(this.student).subscribe();
      this.dialogRef.close();
      this.openSnackBar("You have successfully added a Student", "Close");
    }
    else if (user['role'] === 'Teacher') {
      delete user['role'];
      this.teacher = user;
      this.adminService.addNewTeacher(this.teacher).subscribe();
      this.dialogRef.close();
      this.openSnackBar("You have successfully added a Teacher", "Close");
    }
    else if (user['role'] === 'Administration') {
      delete user['role'];
      this.administrator = user;
      this.adminService.addNewAdministration(this.administrator).subscribe();
      this.dialogRef.close();
      this.openSnackBar("You have successfully added an Admin Worker", "Close");
    }
  }

  checkPasswords(group: FormGroup) {
    let pass = group.controls.password.value;
    let confirmPass = group.controls.confirmPassword.value;

    return pass === confirmPass ? null : { notSame: true }
  }

  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 3000,
    });
  }

}


