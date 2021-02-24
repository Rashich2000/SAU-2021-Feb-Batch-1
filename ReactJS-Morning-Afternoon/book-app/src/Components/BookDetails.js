import React, {useState, useEffect, Component} from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from 'react-router-dom'

import NavBar from "./NavBar.js";
import { Card, Button} from 'react-bootstrap';
import books from "../books";


function BookDetails(props){
    console.log("in book details");
    var bid=props.match.params.id;
    var selected_book=books.filter(book=>book.id==bid);
    return(
        <div>
        <NavBar />
        <Card border="dark" bg="dark" text="white" style={{display:"flex",margin:40}}>
        <Card.Body>
            <Card.Title>{selected_book[0].title}  By {selected_book[0].author} </Card.Title>
            <Card.Text>
            {selected_book[0].description}
            </Card.Text>
            <Link to="/"><Button bg="white" >Go Back</Button></Link>          
        </Card.Body>
        </Card>
        
        </div>
    );
    

}

export default BookDetails;

