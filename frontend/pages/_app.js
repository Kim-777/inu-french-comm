import React from 'react';
import Head from 'next/head';
import 'antd/dist/antd.css';
import Header from '../components/common/Header';
import Footer from '../components/common/Footer';

const App = ({ Component }) => {
    return (
        <div>
            <Head>
                <meta charSet="utf-8" />
                <title>inu-french</title>
                <link rel="shortcut icon" href="/favicon.png" />
            </Head>
            <Header />
            <Component />
            <Footer />
        </div>
    )
}

export default App;
