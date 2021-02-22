import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import {Info} from '../modal/info';
import { InfoService } from '../info.service';
import { MatDialog } from '@angular/material/dialog';
import {AddInfoComponent} from '../add-info/add-info.component'
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
@Component({
  selector: 'app-au-list',
  templateUrl: './au-list.component.html',
  styleUrls: ['./au-list.component.scss']
})
export class AuListComponent implements OnInit {

  infoForm:FormGroup | undefined;
  infoItems: Info[]=[];
  recordlen: number =0;
  isClicked: boolean[]=[];
  constructor(private service_Info: InfoService,private dialog:MatDialog,private router : Router) { }
  
  ngOnInit(): void {
    this.infoItems=this.service_Info.getInfo();
    this.recordlen=this.service_Info.getCount();
    for(var i=0;i<this.recordlen;i++){
      this.isClicked[i]=false;
    }
    this.infoForm = new FormGroup({
      sess_name : new FormControl('', Validators.required),
      instr_name : new FormControl(''),
      description: new FormControl('')
    }); 
  }

    get sess_name()
    {
      return this.infoForm?.get('sess_name') as FormControl;
    }
  
    get instr_name(){
      return this.infoForm?.get('instr_name') as FormControl;
    }

    get description(){
      return this.infoForm?.get('description') as FormControl;
    }


  

  updateInfo(indexno:number){
    this.isClicked[indexno]=!this.isClicked[indexno];
    
    if(this.isClicked[indexno]==false){
    const info:Info = {
      session_name : this.sess_name.value,
      instructor_name: this.instr_name.value,
      desc: this.description.value
      }
      console.log(info);
      this.service_Info.addInfoAtIndex(indexno,info);
    }    
    else{

    }
    this.router.navigate(['/list']); 
    
  }

  deleteInfo(indexno:number){
      this.service_Info.deleteAtIndex(indexno);
  }
  /*
  addToList() {
    this.dialog.open(AddInfoComponent, {
      width:'300px'
    });
  }
  */
  
}
