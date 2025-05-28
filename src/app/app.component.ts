import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { RouterModule } from '@angular/router';
import { CreateEmployeeComponent } from './create-employee/create-employee.component'
import { FormsModule } from '@angular/forms';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';

@Component({
  selector: 'app-root',
  imports: [EmployeeListComponent, 
    RouterOutlet, 
    CreateEmployeeComponent, 
    RouterModule, 
    FormsModule,
    UpdateEmployeeComponent,
    EmployeeDetailsComponent],
  standalone : true,  
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Angular 17 Spring Boot CRUD Full Stack App';
}
