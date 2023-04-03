import Head from 'next/head'
import styles from '../src/styles/Layout.module.css'


export default function Layout({title, keywords, description, children}) {
    return (
        <div>
            <Head>
                <title>{title}</title>
                <meta name='keywords' content={keywords}/>
                <meta name='description' content={description}/>
            </Head>

            <div className={styles.container}>
                {children}
            </div>
        </div>
    )
} 

Layout.defaultProps = {
    title: "My Finances",
    Description: "Complete picture of my finances",
    keywords: "finance accounts"
}