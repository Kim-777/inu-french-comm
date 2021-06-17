import React from "react";
import styled from "@emotion/styled";

const Margin = styled.div`
    padding: 5px;
`;

const FrenchdotWrapper = styled.div`
    span {
        display: inline-block;
        margin: 0 2px;
        width: 10px;
        height: 10px;
        background-color: gray;
        border-radius: 50%;
        animation: loading 1s 0s linear infinite;
    }

    span:nth-child(1) {
        /*loading의 자식 중 첫번째 span*/
        /*nth-child : 형제 사이에서의 순서*/
        animation-delay: 0s;
        background-color: blue;
    }

    span:nth-child(2) {
        border: 1px solid rgba(216, 225, 240, 0.6);
        animation-delay: 0.2s;
        background-color: white;
    }

    span:nth-child(3) {
        animation-delay: 0.4s;
        background-color: red;
    }

    @keyframes loading {
        /*loading이라는 keyframe 애니메이션*/
        0%,                     
        100% {
            opacity: 0; /* 안보였다가 */
            transform: scale(
                0.5
            ); /*transform의 scale로 요소를 확대 또는 축소할 수 있음*/
        }
        50% {
            opacity: 1; /* 보였다가 */
            transform: scale(1.2); /* 1.2배 */
        }
    }
`;

const Frenchdot = () => {
    return (
        <>
        <FrenchdotWrapper>
            <span></span>
            <span></span>
            <span></span>
        </FrenchdotWrapper>
        <Margin />
        </>
    );
};

export default Frenchdot;
