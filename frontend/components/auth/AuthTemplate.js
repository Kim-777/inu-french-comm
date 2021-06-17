import React from 'react';
import styled from '@emotion/styled';
import Link from 'next/link';
import Frenchdot from '../common/Frenchdot';

const AuthTemplateBlock = styled.div`
    height: calc(100vh - 300px);
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
`;

const RapperBox = styled.div`

    box-shadow: 0 0 8px rgba(0, 0, 0, 0.025);
    padding: 2rem;
    min-width: 320px;
    width: 40vw;
    background-color: #edf4ff;
    border-radius: 3px;

    .logo-area {
        display: block;
        padding-bottom: 2rem;
        text-align: center;
        font-weight: bold;
        letter-spacing: 2px;
    }
`;




const AuthTemplate = ({ children }) => {
    return (
        <AuthTemplateBlock>
            <Frenchdot />
            <RapperBox>
                <div className="logo-area">
                    <Link href="/"><a>INU FRENCH</a></Link>
                </div>
                {children}
            </RapperBox>
        </AuthTemplateBlock>
    )
}

export default AuthTemplate;
