package top.whl.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Halo
 * @date Created in 2020/07/31  12:08
 * @description BeanPostProcessor的实现类
 */
public class BeanPostProcessorImpl implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[" + bean.getClass().getSimpleName() + "]对象" + beanName + "开始实例化");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[" + bean.getClass().getSimpleName() + "]对象" + beanName + "实例化完成");
        return bean;
    }
}
