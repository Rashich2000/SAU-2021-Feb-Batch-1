import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from 'react-router-dom'
import { Card, Button} from 'react-bootstrap';
import BookDetails from './BookDetails.js'
function BookList(props){

    
    console.log("in list");
    return( 
        <Card border="success" style={{ width: '30rem', height: '20rem', margin:30 }}>
        <Card.Body>
            <Card.Title style={{fontSize:30}}> {props.book.title} </Card.Title>
            <br/>
            <Card.Text style={{fontSize:18}}>
            By- {props.book.author}
            <br/>
            Genre- {props.book.genre}
            </Card.Text>
            <Link to={"/"+props.book.id+"/"}><Button bg="dark">Click  Me</Button></Link>
        </Card.Body>
        </Card>
    );
}

export default BookList;