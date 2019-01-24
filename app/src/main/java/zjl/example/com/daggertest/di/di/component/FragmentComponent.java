package zjl.example.com.daggertest.di.di.component;

import dagger.Component;
import zjl.example.com.daggertest.di.di.module.FragmentModule;
import zjl.example.com.daggertest.di.di.scope.FragmentScope;
import zjl.example.com.daggertest.ui.HomeFragment;


@FragmentScope//子类component的Scoped 要小于父类的Scoped，所以添加注解指明范围，参考单利注意事项
@Component(modules = FragmentModule.class, dependencies = ApplicationComponent.class)
public interface FragmentComponent {
//    void inject(HomeFragment homeFragment);
//    void inject(ProjectFragment projectFragment);
//    void inject(ProjectTabPageFragment projectTabPageFragment);
//    void inject(HierarchyFragment hierarchyFragment);
//    void inject(HierarchyTabPageFragment hierarchyTabPageFragment);
//    void inject(NavigationFragment navigationFragment);
//    void inject(MineFragment mineFragment);
//    void inject(SearchResultFragment searchResultFragment);
//    void inject(SearchSuggestFragment searchSuggestFragment);
//    void inject(SignInFragment signInFragment);
//    void inject(SignUpFragment signUpFragment);
}
