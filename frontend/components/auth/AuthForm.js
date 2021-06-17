import React from 'react';
import styled from '@emotion/styled';
import Button from '../common/Button';
import Link from 'next/link';


const AuthFormBlock = styled.div`

    h3 {
        margin: 0;
        margin-bottom: 1rem;
    }

`;

const StyledInput = styled.input`
    font-size: 1rem;
    border: none;
    border-bottom: 1px solid gray;
    padding-bottom: 0.5rem;
    outline: none;
    width: 100%;

    &:focus {
        color: orange;
        border-bottom: 1px solid orange;
    }

    & + & {
        margin-top: 1rem;
    }
`;

const AuthFooter = styled.div`
    margin-top: 2rem;
    text-align: right;

    a {
        color: gray;
        text-decoration: underline;
        &:hover {
            color: black;
        }
    }
`;

const ButtonWithMarginTop = styled(Button)`
    margin-top: 1rem;
`;

const AuthForm = () => {
    return (
        <AuthFormBlock>
            <h3> 로그인 페이지</h3>
            <form>
                <StyledInput 
                    autoComplete="username" 
                    name="username" 
                    placeholder="아이디"
                />
                <StyledInput
                    autoComplete="new-password"
                    name="password"
                    placeholder="비밀번호"
                    type="password"
                />
                <ButtonWithMarginTop fullWidth>로그인</ButtonWithMarginTop>
            </form>
            <AuthFooter>
                <Link href="/signup"><a>회원가입 하러 가기</a></Link>
            </AuthFooter>
        </AuthFormBlock>
    )
}

export default AuthForm;
