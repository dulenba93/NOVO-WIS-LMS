import { Component, OnInit, ViewChild } from '@angular/core';
import { AdminService } from 'src/app/services/admin-service/admin.service';
import {MatTableDataSource,MatSort, MatPaginator,MatDialog,MatDialogConfig} from '@angular/material'
import { User } from 'src/app/model/user';
import { RegisterComponent } from 'src/app/register/register.component';


@Component({
  selector: 'app-all-users',
  templateUrl: './all-users.component.html',
  styleUrls: ['./all-users.component.scss']
})
export class AllUsersComponent implements OnInit {

  constructor(private service: AdminService,
              private dialog: MatDialog) { }


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

  applyFilter(){
    this.listData.filter = this.searchKey.trim().toLowerCase();    
  }

  onCreate(){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    this.dialog.open(RegisterComponent,dialogConfig);
  }

  onDelete(id: String){
    this.service.deleteUser(id).subscribe((data: any) => {
      this.getAllUsers();
    });
  }

}
