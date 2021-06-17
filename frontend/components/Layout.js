import React, { Children } from 'react'
import styled from '@emotion/styled';

const LayoutWrapper = styled.div`

    max-width: 1400px;
    margin: 0 auto;
    position: relative;

`;


const Layout = ({ children }) => {
    return (
        <LayoutWrapper>
            {children}
        </LayoutWrapper>
    )
}

export default Layout
