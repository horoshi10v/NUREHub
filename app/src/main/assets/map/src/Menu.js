import React from 'react';
import './Menu.css';
import {DASH_HEIGHT} from './App';

export default class Menu extends React.Component {

    state = {
        itemsClass: 'hidden',
        menuHeight: `${window.innerHeight - DASH_HEIGHT - 2}px`,
        tag: this.props.name
    };

    render() {
        const items = this.props.list.map((x, i) => <li onClick={this.itemClick} key={i.toString()}>{x}</li>);
        return (
            <React.Fragment>
                <button className="menu" onClick={this.menuClick}>{this.state.tag}</button>
                <ul className={this.state.itemsClass}
                    style={ {height: this.state.menuHeight, left: this.props.name === 'To' ? '50px' : '0'} }>
                    {items}
                </ul>
            </React.Fragment>
         );
    }

    itemClick = (e) => {
        this.menuClick();
        const tag = e.target.innerHTML;
        this.setState({tag: tag.slice(0, 7)});
        this.props.onSelect(tag);
    };

    menuClick = () => {
        if (this.state.itemsClass === 'hidden') {
            this.setState({itemsClass: 'visible'});
        } else {
            this.setState({itemsClass: 'hidden'});
        }
    };

}

