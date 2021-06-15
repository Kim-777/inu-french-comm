import React, { useState, useCallback, useRef } from 'react';
import axios from 'axios';


const form = () => {

    const imageInput = useRef();

    const onClickImageUpload = useCallback(() => {
        imageInput.current.click();
    }, [imageInput.current])

    const [name, setName] = useState('');
    const [content, setContent] = useState('')

    const onChangeName = (e) => {
        setName(e.target.value);
    }

    const onChangeContent = (e) => {
        setContent(e.target.value);
    }
    

    const onSubmit = async (e) => {
        e.preventDefault();
        
        const formData = new FormData();

        console.log('imageInput.current.files', imageInput.current.files);

        if(imageInput.current.files) {
            [].forEach.call(imageInput.current.files, (f) => {
                formData.append('image', f);
            });
        }

        // console.log('content', content);
        // console.log('name', name);


        formData.append('content', content);
        formData.append('name', name);

        for (let value of formData.values()) {

            console.log(value);
        
        }

        // console.log('onSubmit', formData);
        try {
            const result = await axios.post('http://localhost:8080/image', formData);

            alert('image 서버 보내기 성공!')
            console.log(result.data);

        } catch (error) {
            alert('에러 발생', error);
        }
    }

    // const onChangeImages = useCallback(async (e) => {
    //     console.log('images', e.target.files);
    //     const imageFormData = new FormData();
    //     [].forEach.call(e.target.files, (f) => {
    //         imageFormData.append('image', f);
    //     });

    // })

    return (
        <div>
            <form
                encType="multipart/form-data"
                onSubmit={onSubmit}
            >
                <input
                    name='name'
                    value={name}
                    onChange={onChangeName}
                />
                <br />
                <input
                    name="content"
                    value={content}
                    onChange={onChangeContent}
                />
                <input
                    type="file"
                    name="image"
                    multiple
                    hidden
                    ref={imageInput}
                />
                <div
                    onClick={onClickImageUpload}
                    style={{
                        backgroundColor: 'pink',
                        cursor: 'pointer',
                        width: '150px',
                        border: '1px solid black'
                    }}
                >이미지 업로드</div>
                <button
                    type="submit"
                >
                    서버로 보내기
                </button>
            </form>
        </div>
    )
}

export default form;
