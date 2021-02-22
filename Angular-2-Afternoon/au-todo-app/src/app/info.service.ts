import { Injectable } from '@angular/core';
import {Info} from './modal/info';
@Injectable({
  providedIn: 'root'
})
export class InfoService {
  infoItems: Info[] =[
    {
      session_name:"VCS, Git",
      instructor_name:"Biresh Kumar Mishra",
      desc:"Introduction to Github"
    },
    {
      session_name:"SQL Concepts and Fundamentals",
      instructor_name:" Tarun K",
      desc:"Introduction to SQL"
    },
    {
      session_name:"Javascript",
      instructor_name:"Rahul Pareek",
      desc:"Introduction to Javascript"
    }
  ];

  constructor() { }

  getInfo(){
    return this.infoItems;
  }

  addInfo(item:Info){
    this.infoItems.push(item);
  }

  addInfoAtIndex(in_:number,item:Info){
    //this.infoItems.splice(in_,1,item);
    this.infoItems[in_]=item;  
  }

  deleteAtIndex(in_:number){
    this.infoItems.splice(in_,1);
  }

  getCount(){
    return this.infoItems.length;
  }
}
