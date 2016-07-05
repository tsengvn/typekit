[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Typekit-green.svg?style=flat)](https://android-arsenal.com/details/1/1957)   [ ![Download](https://api.bintray.com/packages/tsengvn/maven/typekit/images/download.svg) ](https://bintray.com/tsengvn/maven/typekit/_latestVersion)


# typekit
*Typekit* is a library that help you quick change default font of your android application. You don't need to add any custom view or tag to your current xml layout file. You make a quick config in your application class and change the font that you need specific for a style.

Override this in your base activity

```java
@Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
```

and make the setup for fonts in your custom application class
```java
Typekit.getInstance()
                .addNormal(Typekit.createFromAsset(this, "Wedding Chardonnay.ttf"))
                .addBold(Typekit.createFromAsset(this, "Double_Bubble_shadow.otf"))
                .addItalic(Typekit.createFromAsset(this, "Double_Bubble_shadow_italic.otf"))
                .addBoldItalic(Typekit.createFromAsset(this, "Double_Bubble_shadow_italic.otf"))
                .addCustom1(Typekit.createFromAsset(this, "soopafre.ttf"))
                .addCustom2(Typekit.createFromAsset(this, "Break It Down.ttf"));
```

Now the custom font is ready for any class which is subclass of TextView

### Dependency
```groovy
dependencies {
    compile 'com.tsengvn:Typekit:1.0.0'
}
```

### Changes Log
#### v1.0.1
- Fixed bugs
- Add support Toolbar title and subttile
- Add support Html spanned from xml

Licence
=======
    Copyright (c) 2015 Hien Ngo

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
