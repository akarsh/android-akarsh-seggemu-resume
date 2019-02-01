<img align="left" width="80" height="80" src="https://raw.githubusercontent.com/akarsh/android-akarsh-seggemu-resume/master/app/src/main/ic_launcher-web.png" alt="Android resume application project app icon">

# Android - Resume application project

[![Java](https://img.shields.io/badge/java-1.8-blue.svg)](https://developer.android.com/studio/write/java8-support)
[![Android Studio](https://img.shields.io/badge/android%20studio-3.2.1-green.svg)](https://developer.android.com/studio/)
[![Build Status](https://travis-ci.com/akarsh/android-akarsh-seggemu-resume.svg?branch=master)](https://travis-ci.com/akarsh/android-akarsh-seggemu-resume)
[![Maintainability](https://api.codeclimate.com/v1/badges/ec01ba1df913a5e6f2cb/maintainability)](https://codeclimate.com/github/akarsh/android-akarsh-seggemu-resume/maintainability)

This project is developed to show the resume in Android.
The resume is maintained in a JSON format following resume JSON structure.

## Table of Contents

  - [Features](#features)
  - [Requirements](#requirements)
  - [License](#license)

<img height="480" src="Images/demoOfAndroidApp.gif" alt="demo of Android resume application project">

## Features

- [x] Download a remote JSON file in the application.
- [x] Before storing the remote JSON file in the application the following checks are performed, 
    - [x] If the application is running on an emulator or a mobile device.
    - [x] If external storage (SD card) is present and it is removable.
- [x] Store the downloaded remote JSON file in the application.
- [x] Read the stored JSON file in the application.
- [x] Pass data from resume schema layout to other layouts.
- [x] Translate the contents in the application based on the resume language selected by the user.
- [x] Application adapts to different screen sizes.
- [x] Continuous Integration (Travis-CI) to test the application.

## Requirements

- Android 16+
- Android Studio 3+
- Java 1.8

#### License

Resume application project is released under the GNU General Public License v3.0 license. [See LICENSE](https://github.com/akarsh/akarsh-seggemu-resume/blob/master/LICENSE) for details.
