import React from 'react';
import Head from 'next/head';
import 'antd/dist/antd.css';
import Header from '../components/common/Header';
import Footer from '../components/common/Footer';
import '../css/reset.css';
import Layout from '../components/Layout';

const App = ({ Component }) => {
    return (
        <div>
            <Head>
                <meta charSet="utf-8" />
                <title>inu-french</title>
                <link rel="shortcut icon" href="/favicon.png" />
            </Head>
            <Layout>
                <Header />
                <Component />
                <Footer />
            </Layout>
        </div>
    )
}

export default App;
