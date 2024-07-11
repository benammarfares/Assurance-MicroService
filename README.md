
<a  align="center" name="readme-top"></a>

<!-- PROJECT LOGO -->
<br />
<div align="center">
    <img src="https://github.com/user-attachments/assets/93433dcf-f7e7-4f96-9777-a90d18ff10c6" alt="Logo" width="100" height="100">


  <p align="center">
      Micro Service Project about an assurance concept.
    <br />
    <a href="https://github.com/benammarfares/Spring-RestClients"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    ·
    <a href="https://github.com/benammarfares/Spring-RestClients/issues/new?labels=bug&template=bug-report---.md">Report Bug</a>
    ·
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project
![architecture](https://github.com/user-attachments/assets/6b2316dc-bf89-43b8-8130-2b02117106ce)

<br>

* Well, this is my first microservice project that helped me to understand and get familiar with the architecture and concepts.<br>
* This project wil have 2 classes to begin with :<br> 
  * Assurance Class that will have one or many AssurancePolicies .<br>
  * Figure 1 shows the approach used in the project, and I used Zipkin for auto-configuration and distributed tracing.<br>



    
<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With
<br>

* ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started
<br>

<div style="text-align: center;">
  <img src="https://github.com/user-attachments/assets/63559c2b-34d2-4e88-bef8-60d2aaecd627" alt="DiagrammeClass">
</div>

* This project is based on microservice architecture ,  to do so :<br>
   * 1. Configured the discovery server using Eureka.<br>
   * 2. Developed the Microservice Implementation (Assurance):<br>
      * Implemented the first microservice class named Assurance.<br>
   * 3. Second Microservice Implementation (Assurance):<br>
      * Implemented another instance of the AssurancePolicy microservice.<br>
   * 4. Established HTTP connections between the microservices using the OpenFeign dependency.<br>
   * 5. Configured the gateway microservice :<br>
      * The purpose of the gateway is to route requests to the appropriate microservice and to allow microservices to communicate through a single entry point.<br>
   * 6. Config Server Configuration: Configured the Config server.:<br>
      * The Config server ensures that each time the project starts, all microservices pull their configurations from the Config server.<br>

* For testing, I created an apiTest directory where there are HTTP files to test endpoints and microservice connections. <br>

### Prerequisites

* Java 17 or more
* All the dependicies are included in the pom.xml
    * Spring Boot Actuator
    * Eureka Discovery Client
    * Eureka Server
    * Gateway
    * Lombok
    * Spring Data JPA
    * PostgresSQLDriver
    * OpenFeign...

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/benammarfares/Assurance_Micro-Service.git
   ```
2. To test the crud you can use :
  * Postamn.
  * Http files.

   
<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- CONTACT -->
## Contact

 <a href="https://www.linkedin.com/in/fares-ben-ammar-14b8b3226/">
                <img alt="LinkedIn" title="Discord" src="https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white"/></a> 
    <a href="https://www.instagram.com/fares.ben.ammar/?hl=fr">
                <img alt="Instagram" title="Instagram" src="https://img.shields.io/badge/Instagram-%23E4405F.svg?style=for-the-badge&logo=Instagram&logoColor=white"/></a>
        <a href="https://discord.gg/farou1747">
                    <img alt="Discord" title="Discord" src="https://img.shields.io/badge/Discord-%235865F2.svg?style=for-the-badge&logo=discord&logoColor=white"/></a> 
            <a href="https://facebook.com/https://www.facebook.com/faroutiti.benammar/">
                    <img alt="Facebook" title="Facebook" src="https://img.shields.io/badge/Facebook-%231877F2.svg?style=for-the-badge&logo=Facebook&logoColor=white"/></a> 
    <a href="mailto:benammar.Fares@esprit.tn">
    <img alt="Outlook" title="Outlook" src="https://img.shields.io/badge/Microsoft_Outlook-0078D4?style=for-the-badge&logo=microsoft-outlook&logoColor=white"/>



<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

Important to who will start from scratch !!!! :)

- [Spring Developer](https://www.youtube.com/@SpringSourceDev)
- [Josh Long](https://www.youtube.com/@coffeesoftware)
- [DaShaun Carter](https://www.youtube.com/@dashaun)
- [Spring Boot Learning](https://www.youtube.com/@SpringBootLearning)
- [Spring Tips](https://www.youtube.com/playlist?list=PLgGXSWYM2FpPw8rV0tZoMiJYSCiLhPnOc)
- [Amigoscode](https://www.youtube.com/@amigoscode)
- [Java Brains](https://www.youtube.com/c/JavaBrainsChannel)
- [Daily Code Buffer](https://www.youtube.com/@DailyCodeBuffer)




