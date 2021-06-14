import React, { useState, useEffect, useCallback } from 'react';
import axios from 'axios';


const index = () => {

    const [message, setMessage] = useState("test");

    const onClick = useCallback(async () => {
        const result = await axios.get('http:localhost:8080/hello');        
        setMessage(result.data);
    }, []);


    return (
        <div>
            <div>{message}</div>
            <button onClick={onClick}>button!!</button>
        </div>
    )
}

export default index;
