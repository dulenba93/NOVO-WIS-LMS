import { Component, OnInit, ViewChild } from '@angular/core';
import { AdminService } from 'src/app/services/admin-service/admin.service';
import {MatTableDataSource,MatSort, MatPaginator} from '@angular/material'
import { User } from 'src/app/model/user';


@Component({
  selector: 'app-all-users',
  templateUrl: './all-users.component.html',
  styleUrls: ['./all-users.component.scss']
})
export class AllUsersComponent implements OnInit {

  constructor(private service: AdminService) { }


  users: User[] = [];
  user: User = new User();
  listData = new MatTableDataSource<User>(this.users);
  displayedColumns : string[] = ['username','email','role','edit','delete'];

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  searchKey : String;
  

  ngOnInit() {

    this.getAllUsers();
    this.listData.sort = this.sort;
    this.listData.paginator = this.paginator;

    /*
    this.service.getAllUsers().subscribe(
      list => {
        let array = list.map(item =>{
          return{
              $key :item.id,
              ...item.payload.val()
          };

          this.listData = new MatTableDataSource(array);
                })

                
      }
    )
    */
  }

  getAllUsers(){
    this.service.getAllUsers().subscribe((data : User[]) =>{
      this.users = data;
      this.listData.data = data;
    });
  }

  onSearchClear(){
    this.searchKey = "";
  }

  applayFilter(){
    this.listData.filter = this.searchKey.trim().toLowerCase();    
  }

  

}
