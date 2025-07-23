export default function Description(props) {
    return (
        <div>
            <h3>{props.role_title}</h3>
            <p>{props.description}</p>
            <ul>
                {props.functionality.map(
                    (item, index) => <li key={index}>{item}</li>
                )}
            </ul>
        </div>
    )
}