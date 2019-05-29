import { Component, OnInit } from '@angular/core';
import { UniversityService } from 'src/app/services/university-service/university.service';
import { University } from 'src/app/model/university';
//import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-university',
  templateUrl: './university.component.html',
  styleUrls: ['./university.component.scss']
})


export class UniversityComponent implements OnInit {

  private university : University[];



  constructor(private universityService: UniversityService) { }

  ngOnInit() {
    this.universityService.getAllUniversities().subscribe(
      data => {
        this.university = data.map(item =>{
            return{
              id: item.id,
              name: item.name,
              year: item.year,
              address: item.address,
            };
  
        })
        
      }
    )
    console.log(this.university[0].name);

  }

  enterUniversity(selectedUniversity){

  
  }

}
