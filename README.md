# Education.Spring.dmDev

[![total time](https://wakatime.com/badge/user/b33e0124-90c1-44a9-95a8-0f09b324ad70/project/74444a0e-3c62-4e64-8024-a40f578dbd3e.svg)](https://wakatime.com/badge/user/b33e0124-90c1-44a9-95a8-0f09b324ad70/project/74444a0e-3c62-4e64-8024-a40f578dbd3e)

## What is the project about?

Repository is for educational purpose - learning a Spring framework.
I am watching the [course][1] about Spring framework,
making some notes and adding them to the project, writing examples from the
videos and mastering my skill in this framework.

## What is the purpose of this project?

The **purpose** of the project is ***learning more*** about the framework,
how it should be used correctly to get the *most benefit*. As for me, I have got
a little experience of using [Spring][2] after previous course, but now I want to know more
about how it is used in web-applications.

## Getting Started

As there isn't a real or PET project, for viewing the all notes, which were made
during my study, you can switch between branches and see my notes, some examples
of code for each lesson.

### Prerequisites

For running some branches of the projects you need the next:

* [Xmind](https://xmind.app/) - if you need to edit some my notes and then save it. Otherwise, you can see
  my notes in .png extension without any downloading additional program.
### Installation Instruction

#### How to download project on my local machine?

For downloading the project locally you can use two variants:

1. Download the ZIP archive from the repository page.

   The method is easy, the next steps helps you:
2. Find the button `Code` and press it.
3. Find the button `Download ZIP` and press it. The downloading must start.
4. Unzip the archive in soe directory and run the IDEA in this directory.

Project has been installed. After opening it in your IDEA, the `Maven` downloads
some additional dependencies.

1. Use the `Git` for downloading the repository locally.

   The method a lit bit difficult, but the project will be downloaded with the help
   of several commands, and not manually, as in the previous method. For this method
   you **need** to [install][4] the `Git Bash` on your computer, make some configuration and have a primary skill of
   using this system of version control.
2. Enter your [name][5], [email][6] of GitHub account locally on your machine.
3. Create an empty directory and initialize it as git repository. Use the next
   command - `git init`.
4. Adds this repository to yours with name `origin` (you can change it, if you want):
    ```
   $ git remote add origin git@github.com:StasonMendelso/Education.Spring.dmDev.git
   ```
   But you need configure your SSH connection to your GitHub profile in Git Bash. See more [here][7].

   For viewing that the repository has been added successfully to your local
   repository, you need execute the next command and get the following result:
   ```
   $ git remote -v
   ```
   ![git remote repository](images/img.png)

   After this step your local repository has got a 'connection' to the remote
   project from the GitHub repository.
5. For downloading the project use the following command:
   ```
   $ git pull origin main
   ```
   After these steps your project directory must contain the project files from
   GitHub repository. In addition to, you can create a new branch, make some
   changes and create a pull request for suggesting your improvements. Also, all
   changes are observed by the `git` and you can always make a rollback of
   all changes `git reset --hard`.

[//]: # (#### What things you need to install the software and how to install them)



## Built With

* [Gradle](https://gradle.org/) - Dependency Management

## Author

* **Stanislav Hlova** - *All work* - [StasonMendelso](https://github.com/StasonMendelso)

[1]:https://www.udemy.com/course/spring-dmdev/

[2]:https://spring.io/

[4]:https://git-scm.com/downloads

[5]:https://docs.github.com/en/get-started/getting-started-with-git/setting-your-username-in-git

[6]:https://docs.github.com/en/account-and-profile/setting-up-and-managing-your-personal-account-on-github/managing-email-preferences/setting-your-commit-email-address

[7]:https://docs.github.com/en/authentication/connecting-to-github-with-ssh