import React, { useState, useCallback, useEffect } from 'react';
import axios from 'axios';

const Home = () => {

    const [message, setMessage] = useState("test");

    const onClick = useCallback(async () => {

        const result = await axios.get('http://localhost:8080/hello');
        setMessage(result.data);
    }, []);

    return (
        <div>
            <div>ㅆㅂ</div>
            <div>{message}</div>
            <button onClick={onClick}>click!</button>
        </div>
    )
}

export default Home;
