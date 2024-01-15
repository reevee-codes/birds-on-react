'use strict';

// tag::vars[]
const React = require('react'); // <1>
const ReactDOM = require('react-dom'); // <2>
const client = require('./client'); // <3>
// end::vars[]

// tag::app[]
class App extends React.Component { // <1>

	constructor(props) {
		super(props);
		this.state = {birbs: []};
	}

	componentDidMount() { // <2>
		client({method: 'GET', path: '/api/birbs'}).done(response => {
			this.setState({birbs: response.entity._embedded.birbs});
		});
	}

	render() { // <3>
		return (
			<EmployeeList birbs={this.state.birbs}/>
		)
	}
}
// end::app[]

// tag::employee-list[]
class EmployeeList extends React.Component{
	render() {
		const birbs = this.props.birbs.map(birb =>
			<Birb key={birb._links.self.href} birb={birb}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Description</th>
					</tr>
					{birbs}
				</tbody>
			</table>
		)
	}
}
// end::employee-list[]

// tag::employee[]
class Birb extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.birb.firstName}</td>
				<td>{this.props.birb.color}</td>
				<td>{this.props.birb.description}</td>
			</tr>
		)
	}
}
// end::employee[]

// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
)
// end::render[]
