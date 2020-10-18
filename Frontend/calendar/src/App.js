import React, { useState} from 'react';
import Calendar from './components/Calendar'
import moment from 'moment'

function App() {
  const [value, setValue] = useState(moment())
  return (
    <div>
      <Calendar value={value} onChange={setValue}/>
    </div>
  );
}

export default App;
