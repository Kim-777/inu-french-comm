import React from 'react';
import styled from '@emotion/styled';
import { css, jsx } from '@emotion/react'

const StyledButton = styled.button`
    border: none;
    border-radius: 5px;
    font-size: 1rem;
    font-weight: bold;
    padding: 0.25rem 1rem;
    color: white;
    outline: none;
    cursor: pointer;
    transition: all ease-in 300ms; 

    background: rgba(20, 63, 150, 0.3);

    &:hover {
        background:  rgba(20, 63, 150, 1);
    }

    ${props => 
        props.fullWidth &&
        css`
            padding-top: 0.75rem;
            padding-bottom: 0.75rem;
            width: 100%;
            font-size: 1.125rem;
        `
    }
`;

const Button = (props) => {
    return (
        <StyledButton {...props} />
    )
}

export default Button
