import React from "react";
import { Provider } from "react-redux";
import store from "./store";
import Home from "./Home";
import Footer from "./Footer";

function App() {
    return (
        <Provider store={store}>
            <div>
                <Home/>
                <div style={{height: "1000px"}}></div>
                <Footer/>
            </div>
        </Provider>
    )
}

export default App;
