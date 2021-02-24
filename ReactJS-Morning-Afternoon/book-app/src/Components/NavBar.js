import React, {useState, useEffect, Component} from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Nav} from 'react-bootstrap';
import { Navbar } from 'react-bootstrap';
import { Link } from 'react-router-dom'
import books from "../books";
import BookList from "./BookList.js";
import {Form,FormControl,Button} from 'react-bootstrap';
 


function NavBar() {
    
    const [toggleView,setToggleView]=useState(false);
    const [flag,setFlag]=useState(false);
    const [bid,setBid]=useState(0);
    const [first,setFirst]=useState(false);
    const [searchItem,setSearchItem]=useState("");
    const [searchsuccess,setSearchSuccess]=useState(false);
    const [click,setClick]=useState(false);
    const txt="";
    const [add,setAdd]=useState(false);
    var sbook=[];
    
  
    function update() {
      setFlag(false)
      sbook=books.map((book)=>{
          if(book.title.includes(searchItem)){
            console.log("Item is "+searchItem);
            setSearchSuccess(true);
            setBid(book.id);
            setFlag(true);
          }
        })
        if(flag==false){
          console.log("Item is "+searchItem);
            setSearchSuccess(false);
            setFirst(true);
        }

    }

    return (
      <>
      <br/><br/>

      <Navbar bg="dark" variant="dark">
      <Navbar.Brand href="#home">Accolite</Navbar.Brand>
      <Nav className="mr-auto">
        <Nav.Link href="#home" onClick={()=>{setToggleView(!toggleView)
        setFirst(false)
        setSearchSuccess(false);}}>Display</Nav.Link>
      </Nav>
      <Form inline>
        <FormControl id="search_book" type="text" placeholder="Search" className="mr-sm-2"   onChange={e => setSearchItem(e.target.value)} />
        <Button variant="outline-info" onClick={update} > Search for Book</Button>
      </Form>
      </Navbar>

         
      <div id="abc" style={{display:"flex", justifyContent:"center",flexWrap:"wrap",backgroundColor:'#F5F5F5', margin:40}}>
        {searchsuccess? <div><h1>Book Found.</h1><Link to={"/"+bid+"/"}><Button bg="dark" style={{position:"relative",margin:20}}>More Info</Button></Link></div>
        :first?<h1>Book Not Found</h1>:null}
        
      </div>
      

      
      <div style={{display:"flex", justifyContent:"center",flexWrap:"wrap",backgroundColor:'#F5F5F5', margin:30}}>
        {toggleView?  books.map( (book_info) => (
        <BookList book= {book_info} />)) :  null }
      </div>
    </>
    );
  }

 
  export default NavBar;