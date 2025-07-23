import { useState } from 'react';

export default function AddContent() { 
    
    const [contentList, setContentList] = useState([]);
    
    const addContent = (newText) => {
        setContentList(prevContent =>[...prevContent, newText]);
    }
    
  return (
    <div>
      <h2>FAQ</h2>

      <Button onClick={() => addContent("Тут текст как пользоваться системой")}>
        Как пользоваться системой?
      </Button>

      <div>
        {contentList.map((text, index) => (
          <h3 key={index}>{text}</h3>
        ))}
      </div>
    </div>
  );
}