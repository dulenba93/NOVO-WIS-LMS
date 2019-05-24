import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators} from '@angular/forms'
import { AdminService } from '../services/admin-service/admin.service';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material';
import { Student } from '../model/student';
import { PlaceService } from '../services/place-service/place.service';
import { Teacher } from '../model/teacher';
import { Place } from '../model/place';
import { Administration } from '../model/administration';
import { AddressService } from '../services/address-service/address.service';
import { Address } from '../model/address';

// export class RegistrationValidator {
//   static validate(registrationFormGroup: FormGroup) {
//       let password = registrationFormGroup.controls.password.value;
//       let repeatPassword = registrationFormGroup.controls.repeatPassword.value;

//       if (repeatPassword.length <= 0) {
//           return null;
//       }

//       if (repeatPassword !== password) {
//           return {
//               doesMatchPassword: true
//           };
//       }

//       return null;

//   }
// }

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  address: Address = new Address();
  student: Student = new Student();
  teacher: Teacher = new Teacher();
  administrator: Administration = new Administration();

  hide = true;

  roles: string[] = ['Student', 'Teacher', 'Administration'];

  places: Place[];

  role: string = '';

  roleForm: FormGroup;
  studentForm: FormGroup;
  otherForm: FormGroup;
  addressForm: FormGroup;

  constructor(
    private addressService: AddressService,
    private placeService: PlaceService,
    private adminService: AdminService,
    private fb: FormBuilder,
    public dialogRef: MatDialogRef<RegisterComponent>,
    private snackBar: MatSnackBar
  ) {
  }

  ngOnInit() {

    this.roleForm = this.fb.group({
      role: [null, Validators.required]
    });

    this.studentForm = this.fb.group({
      firstName: [null, Validators.required],
      lastName: [null, Validators.required],
      street: [null, Validators.required],
      place: [null, Validators.required],
      number: [null, Validators.required],
      username: [null, [Validators.required, Validators.minLength(6)]],
      password: [null, [Validators.required, Validators.minLength(8)]],
      confirmPassword: [null, [Validators.required, Validators.minLength(8)]],
      email: [null, [Validators.required, Validators.email]],
      role: [null, Validators.required],
      cardNumber: [null, Validators.required]
    });

    this.otherForm = this.fb.group({
      firstName: [null, Validators.required],
      lastName: [null, Validators.required],
      street: [null, Validators.required],
      place: [null, Validators.required],
      number: [null, Validators.required],
      username: [null, [Validators.required, Validators.minLength(6)]],
      password: [null, [Validators.required, Validators.minLength(8)]],
      confirmPassword: [null, [Validators.required, Validators.minLength(8)]],
      email: [null, [Validators.required, Validators.email]],
      role: [null, Validators.required],
      cardNumber: [null, Validators.required]
    })

    this.addressForm = this.fb.group({
      street: [null, Validators.required],
      place: [null, Validators.required],
      number: [null, Validators.required]
    })

    this.getPlaces();
  }

  addressSubmit() {
    const address = this.addressForm.value;
    this.address = address;
    this.addressService.addAddress(this.address).subscribe();
  }

  userSubmit() {
    const user = this.registerForm.value;
    delete user['confirmPassword']
    if (user['role'] === 'Student') {
      delete user['role'];
      this.student = user;
      this.adminService.addNewStudent(this.student).subscribe();
      this.dialogRef.close();
      this.openSnackBar("You have successfully added a Student", "Close");
    }
    else if (user['role'] === 'Teacher') {
      delete user['role'];
      delete user['cardNumber']
      this.teacher = user;
      this.adminService.addNewTeacher(this.teacher).subscribe();
      this.dialogRef.close();
      this.openSnackBar("You have successfully added a Teacher", "Close");
    }
    else if (user['role'] === 'Administration') {
      delete user['role'];
      delete user['cardNumber']
      this.administrator = user;
      this.adminService.addNewAdministration(this.administrator).subscribe();
      this.dialogRef.close();
      this.openSnackBar("You have successfully added an Admin Worker", "Close");
    }
  }

  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 3000,
    });
  }

  getPlaces(){
    this.placeService.getPlaces().subscribe(data => this.places = data);
  }

}


