import React, { useState, useCallback, useEffect } from "react";
import axios from "axios";
import Link from "next/link";
import { Button, Menu, Row, Col, Layout } from "antd";


const { Header, Footer, Sider, Content} = Layout;


const Home = () => {
    const [message, setMessage] = useState("test");

    const onClick = useCallback(async () => {
        const result = await axios.get("http://localhost:8080/hello");
        setMessage(result.data);
    }, []);

    return (
        <div>
            <Link href="/form">
                <a>이미지 보내는 곳으로 가기</a>
            </Link>
            <div>hello</div>
            <div>hello</div>
            <div>{message}</div>
            <Button type="primary">antd Button</Button>
            <button onClick={onClick}>click!</button>
        </div>
    );
};

export default Home;
