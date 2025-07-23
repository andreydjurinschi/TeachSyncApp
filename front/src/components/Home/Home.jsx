import { projectInfo } from '../../data';
import Description from './Description';

export default function Home(props) {
  return (
    <div>
      <h3>{props.title}</h3>
      <p>{props.description}</p>
      <ul>
        {props.features.map((features, index) => (
          <li key={index}>{features}</li>
        ))}
      </ul>
      <Description 
        role_title = {projectInfo.roles.teacher.title}
        description = {projectInfo.roles.teacher.description}
        functionality = {projectInfo.roles.teacher.functionality}
      />
      <Description 
        role_title = {projectInfo.roles.manager.title}
        description = {projectInfo.roles.manager.description}
        functionality = {projectInfo.roles.manager.functionality}
      />
      <Description 
        role_title = {projectInfo.roles.admin.title}
        description = {projectInfo.roles.admin.description}
        functionality = {projectInfo.roles.admin.functionality}
      />
    </div>
  );
}
