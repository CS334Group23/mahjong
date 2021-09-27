# Guidance on how to contribute

## Project Structure

### main branch

The `main` branch is the branch to release the stable version of source code, which means it is fully functional and seldom update. 

**Every contributor should not directly push, merge or pull request to this branch.**

### dev branch

The `dev` branch is the main branch for the group development, every contributor can make a pull request to this branch after testing and solving conflict on your own.

## Contribution Procedures

1. Fork the repository in the organization to your own GitHub account.
2. Clone the repository in your own GitHub account to your local machine.
3. Set the repository in the organization as an upstream to receiving update by other contributors (or manually fetch upstream on GitHub before each development) .
4. Check out to your own development branch and do your own development.
5. Merge to the `dev` branch in your own repository (pay attention to the conflict) and make pull request.

## Small Suggestions

- Fetch the upstream every time you start your development.
- Solve conflict in your own repository before pull request. 
- **Please follow the [java doc comment rules](https://docs.oracle.com/javase/7/docs/technotes/tools/windows/javadoc.html) to write your documentation for each file, class and method.**

